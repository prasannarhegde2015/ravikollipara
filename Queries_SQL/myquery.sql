use POP3
select Well.welWellName as "WellName",  wdaOilRateAllocated ,wdaWaterRateAllocated , WellDailyAverage.wdaOilRateAllocated + WellDailyAverage.wdaWaterRateAllocated as "LiquidRate", 

0.1589873 * (WellDailyAverage.wdaOilRateAllocated + WellDailyAverage.wdaWaterRateAllocated) as "LiquidRate_Metric",

WellDailyAverage.wdaStartDate, WellDailyAverage.wdaEndDate from   WellDailyAverage inner join Well on Well.welPrimaryKey = WellDailyAverage.wdaFK_Well where well.welWellName in ('ESPWELL_00186','ESPWELL_00001','ESPWELL_00187')


--  For GL Wells
select Well.welWellName as "WellName",  wdaOilRateAllocated ,wdaWaterRateAllocated , WellDailyAverage.wdaOilRateAllocated + WellDailyAverage.wdaWaterRateAllocated as "LiquidRate", 

0.1589873 * (WellDailyAverage.wdaOilRateAllocated + WellDailyAverage.wdaWaterRateAllocated) as "LiquidRate_Metric",

WellDailyAverage.wdaStartDate, WellDailyAverage.wdaEndDate from   WellDailyAverage inner join Well on Well.welPrimaryKey = WellDailyAverage.wdaFK_Well where well.welWellName in ('GLWELL_00001','GLWELL_00008','GLWELL_00009','GLWELL_00011')

--For NF Wells
select Well.welWellName as "WellName",  wdaOilRateAllocated ,wdaWaterRateAllocated , WellDailyAverage.wdaOilRateAllocated + WellDailyAverage.wdaWaterRateAllocated as "LiquidRate", 

0.1589873 * (WellDailyAverage.wdaOilRateAllocated + WellDailyAverage.wdaWaterRateAllocated) as "LiquidRate_Metric",

WellDailyAverage.wdaStartDate, WellDailyAverage.wdaEndDate from   WellDailyAverage inner join Well on Well.welPrimaryKey = WellDailyAverage.wdaFK_Well where well.welWellName in ('NF_001','NF_002')
