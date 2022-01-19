/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.kogito.benchmarks;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.kie.kogito.benchmarks.framework.App;
import org.kie.kogito.benchmarks.framework.HTTPRequestInfo;

public class PMMLScorecardSpringBootTest extends AbstractTemplateTest {

    private static final App APP_TO_TEST = App.PMML_SCORECARD_SPRING_BOOT;

    @Test
    public void startStop(TestInfo testInfo) throws IOException, InterruptedException {
        startStop(testInfo, APP_TO_TEST);
    }

    @Test
    public void loadTest(TestInfo testInfo) throws IOException, InterruptedException {
        HTTPRequestInfo requestInfo = HTTPRequestInfo.builder()
                .URI(LOCALHOST + "/SimpleScorecardWithTransformations")
                .body(HTTPRequestInfo.Body.PMML_SCORECARD)
                .method("POST")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .expectedResponseStatusCode(200)
                .build();

        loadTest(testInfo, APP_TO_TEST, requestInfo);
    }
}
