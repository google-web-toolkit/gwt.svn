/*
 * Copyright 2010 Google Inc.
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
package com.google.gwt.resources.css.ast;

/**
 * Represents a CSS at-rule that CssResource is unable to process.
 */
public class CssUnknownAtRule extends CssNode {

  private final String rule;

  public CssUnknownAtRule(String rule) {
    this.rule = rule;
  }

  /**
   * Returns the entire unprocessed at-rule declaration.
   */
  public String getRule() {
    return rule;
  }

  @Override
  public boolean isStatic() {
    return true;
  }

  public void traverse(CssVisitor visitor, Context context) {
    if (visitor.visit(this, context)) {
      // Do nothing
    }
    visitor.endVisit(this, context);
  }
}
