/*
* Copyright (C) 2015 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

package be.nabu.libs.authentication.resources;

import java.io.IOException;
import java.io.InputStream;

import be.nabu.libs.authentication.impl.role.BaseRoleHandler;
import be.nabu.libs.resources.ResourceReadableContainer;
import be.nabu.libs.resources.api.ReadableResource;
import be.nabu.libs.resources.api.Resource;
import be.nabu.libs.resources.api.ResourceContainer;
import be.nabu.utils.io.IOUtils;

public class ResourceRoleHandler extends BaseRoleHandler {

	private ResourceContainer<?> container;

	public ResourceRoleHandler(ResourceContainer<?> container) {
		this.container = container;
	}
	
	@Override
	protected InputStream getInput(String fileName) throws IOException {
		Resource child = container.getChild(fileName);
		return child == null ? null : IOUtils.toInputStream(new ResourceReadableContainer((ReadableResource) child));
	}

}
