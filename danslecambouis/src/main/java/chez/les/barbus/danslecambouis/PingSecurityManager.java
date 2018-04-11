package chez.les.barbus.danslecambouis;

import java.security.Permission;


public class PingSecurityManager extends SecurityManager {
	private int serverPort = 9091;

	@Override
    public void checkAccept(String host, int port) {
    	if ( isInvalidHost(host) || isInvalidPort(port) )
        	throw new SecurityException("This server is not allowed to be bound to " + host + ":" + port);    
	}

	private boolean isInvalidHost(String host) {
		
		boolean res = (! host.equals("localhost") && ! host.equals("127.0.0.1"));
		System.out.println("host:" + res);
		return res;
	}
	
	private boolean isInvalidPort(int port) {
		boolean res = (port != serverPort && port < 50000);
		System.out.println("port:" + res);
		return res;
	}
	
	@Override
 	public void checkPermission(Permission perm) {}

	@Override
	public void checkPermission(Permission perm, Object context){}
	
 	@Override
 	public void	checkPropertyAccess(String key) {}
}