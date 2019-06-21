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


























import java.util.HashMap;
import java.util.Map;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class Main {
    public static void main( String[] args ) throws Exception {
        String node = args[0];
        String port = args[1];
        String username = args[2];
        String password = args[3];

        JMXServiceURL url = new JMXServiceURL( "service:jmx:rmi:///jndi/rmi://" + node + ":" + port + "/jmxrmi" );
        String[] credentials = {username, password};

        Map<String, String[]> environment = new HashMap<>();
        environment.put( JMXConnector.CREDENTIALS, credentials );
        JMXConnector jmxConnector = JMXConnectorFactory.connect( url, environment );
        MBeanServerConnection mbsc = jmxConnector.getMBeanServerConnection();//Get metrics bean
        ObjectName oName = new ObjectName( "org.apache.cassandra.net:type=FailureDetector" );//create JMX object name
        int downNodes = (int) mbsc.getAttribute( oName, "DownEndpointCount" ); //get number of unavailable nodes

        System.out.println("Down node count: " + downNodes);
    }
}
