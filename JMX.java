import java.lang.management.ManagementFactory;
import java.util.Set;
import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.cassandra.metrics.CassandraMetricsRegistry;

public class Main {
	public static void main(String args[])throws Exception {
		
		try {
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://[172.20.22.6]:7199/jmxrmi");
				JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
				MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
				Set<ObjectInstance> objs = mbsc.queryMBeans(ObjectName.getInstance("org.apache.cassandra.metrics:type=Table,name=ViewLockAcquireTime"), null);
				for (ObjectInstance obj : objs) {
				    Object proxy = JMX.newMBeanProxy(mbsc, obj.getObjectName(),CassandraMetricsRegistry.JmxTimerMBean.class);
				    if (proxy instanceof CassandraMetricsRegistry.JmxTimerMBean) {
				        System.out.println(((CassandraMetricsRegistry.JmxTimerMBean) proxy).get50thPercentile());
				    }  
				}
				jmxc.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		while (true) {
		}
	}
}
