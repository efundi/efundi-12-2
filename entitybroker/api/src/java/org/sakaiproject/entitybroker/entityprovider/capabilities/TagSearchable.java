/**
 * $Id$
 * $URL$
 * TagSearchable.java - entity-broker - Mar 21, 2008 9:39:17 PM - azeckoski
 **************************************************************************
 * Copyright (c) 2008 The Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.opensource.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sakaiproject.entitybroker.entityprovider.capabilities;

import org.sakaiproject.entitybroker.entityprovider.EntityProvider;
import org.sakaiproject.entitybroker.entityprovider.extension.TagSearchProvider;


/**
 * Indicates an entity provider has the capability of allowing the entities associated with it to be searchable by tags
 * <br/> This is one of the capability extensions for the {@link EntityProvider} interface<br/>
 * @deprecated no longer functional, use {@link TagProvideable}
 * 
 * @author Aaron Zeckoski (aaron@caret.cam.ac.uk)
 */
public interface TagSearchable extends Taggable, TagSearchProvider {

   // this space intentionally blank

}
