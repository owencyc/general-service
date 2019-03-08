package owenc.springboot.apigate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自己的配置文件
 */
@Component
@ConfigurationProperties(prefix = "sys")
public class SystemConfig {
    public boolean isOpen_log() {
        return open_log;
    }

    public void setOpen_log(boolean open_log) {
        this.open_log = open_log;
    }

    boolean open_log;
}
