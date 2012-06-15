/*
 * Copyright 2011 Google Inc.
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
package com.google.gwt.sample.mobilewebapp.client.tablet;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.mobilewebapp.presenter.task.TaskReadView;
import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Tablet version of the {@link TaskReadView}.
 */
public class TabletTaskReadView extends Composite implements TaskReadView {

  /**
   * Editor driver for this view.
   */
  interface Driver extends SimpleBeanEditorDriver<TaskProxy, TabletTaskReadView> {
  }

  /**
   * The UiBinder interface.
   */
  interface TabletTaskReadViewUiBinder extends UiBinder<Widget, TabletTaskReadView> {
  }

  /**
   * The UiBinder used to generate the view.
   */
  private static TabletTaskReadViewUiBinder uiBinder = GWT.create(TabletTaskReadViewUiBinder.class);

  @UiField
  DateLabel dueDateEditor;
  @UiField
  Label nameEditor;
  @UiField
  Label notesEditor;

  /**
   * The text box used to save changes or create a new task.
   */
  @UiField
  Button editButton;

  private final Driver driver = GWT.create(Driver.class);

  /**
   * The {@link com.google.gwt.sample.mobilewebapp.presenter.task.TaskEditView.Presenter
   * TaskEditView.Presenter} for this view.
   */
  private Presenter presenter;

  /**
   * Construct a new {@link TabletTaskReadView}.
   */
  public TabletTaskReadView() {
    initWidget(uiBinder.createAndBindUi(this));
    driver.initialize(this);

    // Create a new task or modify the current task when done is pressed.
    editButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (presenter != null) {
          presenter.editTask();
        }
      }
    });
  }

  public SimpleBeanEditorDriver<TaskProxy, ?> getEditorDriver() {
    return driver;
  }

  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }
}
