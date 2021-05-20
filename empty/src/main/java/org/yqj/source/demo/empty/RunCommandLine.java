package org.yqj.source.demo.empty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.text.BadLocationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/8/15
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class RunCommandLine implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        log.info("starting command line ...");
    }

    private static final Pattern BLANK_PATTERN = Pattern.compile("\\s{5,}");

    public static void main(String[] args) {
        String test = "AAAAA          BBBB \n\n\n\n\n\n\n cccc";
        System.out.println(BLANK_PATTERN.matcher(test).replaceAll("  "));
    }
}
