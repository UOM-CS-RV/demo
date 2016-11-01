package mt.edu.um.cs.rv.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import mt.edu.um.cs.rv.eventmanager.engine.config.EventManagerConfigration;
import valour.demo.config.MonitorConfig;

@Configuration
@Import({MonitorConfig.class, EventManagerConfigration.class})
public class MonitoringSystemConfig {

}
