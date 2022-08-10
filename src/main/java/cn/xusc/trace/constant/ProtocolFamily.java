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
package cn.xusc.trace.constant;

/**
 * 协议族
 *
 * @author WangCai
 * @since 2.5
 */
public interface ProtocolFamily {
    /**
     * 协议名
     *
     * @return 协议名
     */
    String name();

    /**
     * 协议头
     *
     * @return 协议头
     */
    String head();

    /**
     * 网络协议
     */
    interface Net extends ProtocolFamily {
        /**
         * http协议
         */
        enum HTTP implements Net {
            HTTP("http://"),
            HTTPS("https://");

            private String head;

            HTTP(String head) {
                this.head = head;
            }

            @Override
            public String head() {
                return head;
            }
        }
    }
}
