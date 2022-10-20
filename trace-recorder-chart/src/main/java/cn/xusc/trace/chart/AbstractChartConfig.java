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

import cn.xusc.trace.chart.constant.ChartRefreshStrategy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 抽象图表配置
 *
 * @author WangCai
 * @since 2.5
 */
@Setter
@Getter
@SuperBuilder
public abstract class AbstractChartConfig {

    /**
     * 图表刷新策略
     */
    @Builder.Default
    private ChartRefreshStrategy chartRefreshStrategy = ChartRefreshStrategy.TIMELY;
}
