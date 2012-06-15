/*
 * Copyright 2009 Google Inc.
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
package com.google.gwt.user.client.rpc.core.java.lang;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

/**
 * Custom field serializer for {@link java.lang.StackTraceElement}.
 */
public final class StackTraceElement_CustomFieldSerializer extends
    CustomFieldSerializer<StackTraceElement> {

  @SuppressWarnings("unused")
  public static void deserialize(SerializationStreamReader streamReader,
      StackTraceElement instance) {
    // No fields
  }

  public static StackTraceElement instantiate(
      SerializationStreamReader streamReader) throws SerializationException {
    return new StackTraceElement(streamReader.readString(),
        streamReader.readString(),
        streamReader.readString(),
        streamReader.readInt());
  }

  public static void serialize(SerializationStreamWriter streamWriter,
      StackTraceElement instance) throws SerializationException {
    streamWriter.writeString(instance.getClassName());
    streamWriter.writeString(instance.getMethodName());
    streamWriter.writeString(instance.getFileName());
    streamWriter.writeInt(instance.getLineNumber());
  }

  @Override
  public void deserializeInstance(SerializationStreamReader streamReader,
      StackTraceElement instance) throws SerializationException {
    deserialize(streamReader, instance);
  }

  @Override
  public boolean hasCustomInstantiateInstance() {
    return true;
  }

  @Override
  public StackTraceElement instantiateInstance(SerializationStreamReader
      streamReader) throws SerializationException {
    return instantiate(streamReader);
  }

  @Override
  public void serializeInstance(SerializationStreamWriter streamWriter,
      StackTraceElement instance) throws SerializationException {
    serialize(streamWriter, instance);
  }
}
