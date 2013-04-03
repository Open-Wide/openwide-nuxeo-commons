/*
* Copyright (c) 2013, Open Wide. All rights reserved.
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
* MA 02110-1301 USA
*/

package fr.openwide.nuxeo.utils.jsf;

import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.DocumentModel;

import fr.openwide.nuxeo.types.TypeDocument;

/**
 * @author mkalam-alami
 *
 */
public class SimpleSelectItemLabelBuilder implements SelectItemLabelBuilder {

    private final String xpath;
    
    public SimpleSelectItemLabelBuilder() {
        xpath = TypeDocument.XPATH_TITLE;
    }
    
    public SimpleSelectItemLabelBuilder(String property) {
        xpath = property;
    }
    
    public String getLabel(DocumentModel model) throws ClientException {
        return (String) model.getPropertyValue(xpath);
    }
    
}