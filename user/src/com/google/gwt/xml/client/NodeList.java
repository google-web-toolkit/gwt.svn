/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.xml.client;

/**
 * This interface represents an immutable ordered collection of nodes.
 */
public interface NodeList  {
  /**
   * This method retrieves the number of items in this <code>NodeList</code> 
   * object.
   * 
   * @return the number of nodes in this <code>NodeList</code> object.
   */  
  int getLength();
  
  /**
   * This method gets the item in the position denoted by <code>index</code>.
   * 
   * @param index - the index to be retrieved
   * @return the item at this index
   */
  Node item(int index);

}