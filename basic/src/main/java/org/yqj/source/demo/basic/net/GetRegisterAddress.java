package org.yqj.source.demo.basic.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Description: 获取本地Address 注册地址
 *
 * @author yaoqijun
 * @date 2020/12/31
 * Email: yaoqijunmail@foxmail.com
 */
public class GetRegisterAddress {

    public static void main(String[] args) throws Exception {
        // 获取local host 本地回环地址，
//        InetAddress inetAddress = InetAddress.getLocalHost();
//        System.out.println(inetAddress);

        // 多网卡获取地址查询
        try {
            NetworkInterface networkInterface = findNetworkInterface();
            Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                try {
                    if (address.isReachable(100)) {
                        System.out.println(address);
                    }
                } catch (IOException e) {
                    // ignore
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static NetworkInterface findNetworkInterface() {

        List<NetworkInterface> validNetworkInterfaces = emptyList();
        try {
            validNetworkInterfaces = getValidNetworkInterfaces();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        NetworkInterface result = null;

        for (NetworkInterface networkInterface : validNetworkInterfaces) {
            Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                try {
                    if (address.isReachable(100)) {
                        result = networkInterface;
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    private static List<NetworkInterface> getValidNetworkInterfaces() throws SocketException {
        List<NetworkInterface> validNetworkInterfaces = new LinkedList<>();
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();
            if (ignoreNetworkInterface(networkInterface)) {
                continue;
            }
            validNetworkInterfaces.add(networkInterface);
        }
        return validNetworkInterfaces;
    }

    private static boolean ignoreNetworkInterface(NetworkInterface networkInterface) throws SocketException {
        return networkInterface == null
                || networkInterface.isLoopback()
                || networkInterface.isVirtual()
                || !networkInterface.isUp();
    }
}
