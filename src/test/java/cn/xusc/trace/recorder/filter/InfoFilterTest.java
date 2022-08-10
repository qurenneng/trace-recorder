/*
 * Copyright 2022 WangCai.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.xusc.trace.recorder.filter;

import cn.xusc.trace.TraceRecorder;
import cn.xusc.trace.config.TraceRecorderConfig;
import cn.xusc.trace.util.TraceRecorderProperties;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * http协议信息过滤器
 *
 * @author wangcai
 */
public class InfoFilterTest {

    @ParameterizedTest
    @MethodSource("generateArgs")
    @DisplayName("Base infoFilter")
    public void infoFilterTest(String info, Object[] argArray) {
        TraceRecorder recorder = new TraceRecorder();
        recorder.log(info, argArray);
    }

    @ParameterizedTest
    @MethodSource("generateArgs")
    @DisplayName("Base httpInfoFilter")
    public void httpInfoFilterTest(String info, Object[] argArray) throws IOException {
        TraceRecorderConfig config = new TraceRecorderProperties()
            .easyLoad(
                new StringReader(
                    "cn.xusc.trace.config.TraceRecorderConfig.infoFilters=cn.xusc.trace.filter.protocol.net.http.HttpInfoFilter"
                )
            )
            .config();
        TraceRecorder recorder = new TraceRecorder(config);
        recorder.log(info, argArray);
    }

    @ParameterizedTest
    @MethodSource("generateArgs")
    @DisplayName("Base httpsInfoFilter")
    public void httpsInfoFilterTest(String info, Object[] argArray) throws IOException {
        TraceRecorderConfig config = new TraceRecorderProperties()
            .easyLoad(
                new StringReader(
                    "cn.xusc.trace.config.TraceRecorderConfig.infoFilters=cn.xusc.trace.filter.protocol.net.http.HttpsInfoFilter"
                )
            )
            .config();
        TraceRecorder recorder = new TraceRecorder(config);
        recorder.log(info, argArray);
    }

    @DisplayName("generate a group args")
    private static Stream<Arguments> generateArgs() {
        Object[] argArray = { "hello" };
        return Stream.of(
            Arguments.arguments("{}/HttpInfoFilter", argArray),
            Arguments.arguments("http://{}/HttpInfoFilter", argArray),
            Arguments.arguments("https://{}/HttpInfoFilter", argArray)
        );
    }
}
