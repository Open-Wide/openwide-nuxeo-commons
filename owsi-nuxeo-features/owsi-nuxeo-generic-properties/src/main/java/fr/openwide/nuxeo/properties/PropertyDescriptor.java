/*******************************************************************************
 * (C) Copyright 2013 Open Wide (http://www.openwide.fr/) and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 ******************************************************************************/
package fr.openwide.nuxeo.properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nuxeo.common.xmap.annotation.XContent;
import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.common.xmap.annotation.XNodeList;
import org.nuxeo.common.xmap.annotation.XNodeMap;
import org.nuxeo.common.xmap.annotation.XObject;

/**
 * 
 * @author mkalam-alami
 *
 */
@XObject(value = "property")
public class PropertyDescriptor {
    
    public static final String TYPE_STRING = "string";
    public static final String TYPE_LIST = "list";
    public static final String TYPE_NUMBER = "number";
    public static final String TYPE_MAP = "map";
    
    @XNode("@name")
    private String name = null;

    @XNode("@type")
    private String type = TYPE_STRING;
    
    @XContent
    private String value = null;

    @XNodeList(value = "value", type = ArrayList.class, componentType = String.class, trim = true)
    public List<String> valuesList = null;

    @XNodeMap(value = "value", key = "@key", type = HashMap.class, componentType = String.class, trim = true)
    Map<String, String> valuesMap = new HashMap<String, String>();
    
    public String getName() {
        return name;
    }

    public Object getType() {
        return type;
    }
    
    public String getStringValue() {
        if (TYPE_STRING.equals(getType())) {
            return value.trim();
        }
        else {
            return null;
        }
    }
    
    public Long getNumberValue() {
        if (TYPE_NUMBER.equals(getType())) {
            return Long.valueOf(value.trim());
        }
        else {
            return null;
        }
    }

    public List<String> getListValue() {
        if (TYPE_LIST.equals(getType())) {
            return valuesList;
        }
        else {
            return null;
        }
    }

    public Map<String, String> getMapValue() {
        if (TYPE_MAP.equals(getType())) {
            return valuesMap;
        }
        else {
            return null;
        }
    }
}
