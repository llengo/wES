package org.datasays.wes.actions;

import okhttp3.HttpUrl;
import org.datasays.wes.core.RequestInfo;
import org.datasays.wes.types.*;
// documentation: https://www.elastic.co/guide/en/elasticsearch/reference/5.x/indices-delete-index.html
public class IndicesDelete extends RequestInfo{

	public IndicesDelete(String baseUrl){
		super(baseUrl);
	}
	public IndicesDelete(HttpUrl baseUrl){
		super(baseUrl);
	}

	// param: time timeout: Explicit operation timeout
	public IndicesDelete timeout(long timeout){
		addParams("timeout", timeout);
		return this;
	}
	// param: time masterTimeout: Specify timeout for connection to master
	public IndicesDelete masterTimeout(long masterTimeout){
		addParams("masterTimeout", masterTimeout);
		return this;
	}
	// body:null
	@Override
	public void setBody(Object body) {
		super.setBody(body);
	}

	//A comma-separated list of indices to delete; use `_all` or `*` string to delete all indices
	private String index;
	public IndicesDelete setParts(String index){
		this.index=index;

		return this;
	}

	@Override
	public String parseUrl(String method) {
		if(!"DELETE".equalsIgnoreCase(method)){
			throw new IllegalArgumentException("Unsupported method:"+method);
		}
		//=>/{index}
		if(index != null ){
			setUrl(index);
			return super.parseUrl(method);
		}

		return null;
	}
}
