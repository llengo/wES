package org.datasays.es2.actions;

import okhttp3.HttpUrl;
import org.datasays.util.collection.StrMap;
import org.datasays.util.http.IRequestInfo;
import org.datasays.es2.ARequestInfo;
import org.datasays.es2.types.*;
/**
* documentation: http://www.elastic.co/guide/en/elasticsearch/reference/master/cluster-update-settings.html
**/
public class ClusterPutSettings extends ARequestInfo{

	public ClusterPutSettings(String baseUrl){
		super(baseUrl);
	}

	/** param: boolean flatSettings: Return settings in flat format (default: false)**/
	public ClusterPutSettings flatSettings(boolean flatSettings){
		addParams("flatSettings", flatSettings);
		return this;
	}
	/** param: time masterTimeout: Explicit operation timeout for connection to master node**/
	public ClusterPutSettings masterTimeout(long masterTimeout){
		addParams("masterTimeout", masterTimeout);
		return this;
	}
	/** param: time timeout: Explicit operation timeout**/
	public ClusterPutSettings timeout(long timeout){
		addParams("timeout", timeout);
		return this;
	}
	/** body:The settings to be updated. Can be either `transient` or `persistent` (survives cluster restart).**/
	@Override
	public void setBody(Object body) {
		super.setBody(body);
	}

	public ClusterPutSettings setParts(){

		return this;
	}

	@Override
	public String parseUrl(String method) {
		if(!"PUT".equalsIgnoreCase(method)){
			throw new IllegalArgumentException("Unsupported method:"+method);
		}
		//=>/_cluster/settings
		setUrl("_cluster", "settings");
		return super.parseUrl(method);

	}
}
