import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/9/3
 * Email: yaoqijunmail@foxmail.com
 */
public class GreetingPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.task("hello", task -> System.out.println("Hello from the GreetingPlugin"));
    }
}
