select WellTest.tstPrimaryKey , WellTest.tstSampleDate , WellTest.tstFK_Assembly , Well.welFacilityId , Well.welPrimaryKey , Well.welWellName 
from ((WellTest  
inner join Assembly on  Assembly.aclPrimaryKey = WellTest.tstFK_Assembly )
inner join Well on Well.welPrimaryKey = Assembly.aclFK_Well) where well.welWellName = 'ESPWELL_00002'
