   INSERT INTO dw.FACT_Product_Merchant_Summary 
   (GroupKey1, GroupKey2, MetricCount, MetricSum, MetricAvg, MetricMax, 
   StreamSource, InStockStatus, ETLLoadTimestamp) 
   VALUES (:groupKey1, :groupKey2, :metricCount, :metricSum, :metricAvg, :metricMax, 
   :streamSource, :inStockStatus, :etlLoadTimestamp)
   