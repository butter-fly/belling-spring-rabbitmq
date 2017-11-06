package com.geese.repair.tools;

import java.util.Vector;

/**
 * 响应对象
 */
public class HttpRespons {

	public String urlString;

	public int defaultPort;

	public String file;

	public String host;

	public String path;

	public int port;

	public String protocol;

	public String query;

	public String ref;

	public String userInfo;

	public String contentEncoding;

	public String content;

	public String contentType;

	public int code;

	public String message;

	public String method;

	public int connectTimeout;

	public int readTimeout;

	public Vector<String> contentCollection;

	public String getContent() {
		return content;
	}

	public String getContentType() {
		return contentType;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Vector<String> getContentCollection() {
		return contentCollection;
	}

	public String getContentEncoding() {
		return contentEncoding;
	}

	public String getMethod() {
		return method;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public String getUrlString() {
		return urlString;
	}

	public int getDefaultPort() {
		return defaultPort;
	}

	public String getFile() {
		return file;
	}

	public String getHost() {
		return host;
	}

	public String getPath() {
		return path;
	}

	public int getPort() {
		return port;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getQuery() {
		return query;
	}

	public String getRef() {
		return ref;
	}

	public String getUserInfo() {
		return userInfo;
	}
}