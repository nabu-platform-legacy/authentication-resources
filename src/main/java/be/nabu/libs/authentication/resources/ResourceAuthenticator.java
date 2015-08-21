package be.nabu.libs.authentication.resources;

import java.io.IOException;
import java.io.InputStream;

import be.nabu.libs.authentication.impl.BasePasswordAuthenticator;
import be.nabu.libs.resources.ResourceReadableContainer;
import be.nabu.libs.resources.api.ReadableResource;
import be.nabu.libs.resources.api.Resource;
import be.nabu.libs.resources.api.ResourceContainer;
import be.nabu.utils.io.IOUtils;

public class ResourceAuthenticator extends BasePasswordAuthenticator {

	private ResourceContainer<?> container;

	public ResourceAuthenticator(ResourceContainer<?> container) {
		this.container = container;
	}
	
	@Override
	protected InputStream getInput(String fileName) throws IOException {
		Resource child = container.getChild(fileName);
		return child == null ? null : IOUtils.toInputStream(new ResourceReadableContainer((ReadableResource) child));
	}

}
