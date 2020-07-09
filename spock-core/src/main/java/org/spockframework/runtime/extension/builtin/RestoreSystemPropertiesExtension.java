/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.spockframework.runtime.extension.builtin;

import org.spockframework.runtime.extension.IAnnotationDrivenExtension;
import org.spockframework.runtime.model.FeatureInfo;
import org.spockframework.runtime.model.SpecInfo;

import spock.util.environment.RestoreSystemProperties;

public class RestoreSystemPropertiesExtension implements IAnnotationDrivenExtension<RestoreSystemProperties> {
  @Override
  public void visitSpecAnnotation(RestoreSystemProperties annotation, SpecInfo spec) {
    for (FeatureInfo feature : spec.getFeatures()) {
      feature.addInterceptor(RestoreSystemPropertiesInterceptor.INSTANCE);
    }
  }

  @Override
  public void visitFeatureAnnotation(RestoreSystemProperties annotation, FeatureInfo feature) {
    feature.addInterceptor(RestoreSystemPropertiesInterceptor.INSTANCE);
  }
}
