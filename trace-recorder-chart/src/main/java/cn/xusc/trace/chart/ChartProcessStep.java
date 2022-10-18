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
package cn.xusc.trace.chart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 图表处理步骤接口
 *
 * @author WangCai
 * @since 2.5
 */
public interface ChartProcessStep {
    /**
     * 运行当前处理步骤
     *
     * @param config 图表配置
     * @param valuePipeline 值管道
     * @param <T> 值管道类型
     * @throws Exception  if execute happen any question.
     */
    <T> void run(AbstractChartConfig config, ValuePipeline<T> valuePipeline) throws Exception;

    /**
     * 值管道
     *
     * @param <T> 值类型
     */
    @Setter
    @Getter
    @AllArgsConstructor
    class ValuePipeline<T> {

        /**
         * 值
         */
        private T value;
    }
}
