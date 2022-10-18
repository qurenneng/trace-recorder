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

/**
 * 图表数据处理者
 *
 * @author WangCai
 * @since 2.5
 */
public abstract class ChartDataProcessor extends Thread {

    /**
     * 图表
     */
    private final Chart CHART;

    /**
     * 基础构造
     *
     * @param chart 图表
     */
    public ChartDataProcessor(Chart chart) {
        super("echartsChartDataProcessor");
        CHART = chart;
    }

    @Override
    public void run() {
        while (true) {
            /*
            提取标准化数据
             */
            ChartData standardChartData;
            try {
                standardChartData = ChartDataRepository.INSTANCE.take();
            } catch (InterruptedException e) {
                break;
            }

            ChartData processedChartData = processStandardChartData(standardChartData);
            CHART.fillData(processedChartData);
        }
    }

    /**
     * 处理标准图数据
     *
     * @param chartData 标准图数据
     * @return 处理后相关性图数据
     */
    protected abstract ChartData processStandardChartData(ChartData chartData);
}
