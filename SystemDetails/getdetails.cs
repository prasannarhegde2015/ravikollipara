using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Management;

namespace SystemDiagnostics
{
    class Program
    {


        enum ProcessorInfo
        {
            AddressWidth,
            Caption,
            MaxClockSpeed,
            NumberOfCores,
            Name
        }
        enum SystemDetail
        {
            SystemType,
            TotalPhysicalMemory,
            UserName,
            Manufacturer,
            Model
        }
        enum OSDetials
        {
            OSArchitecture,
            Caption,
            Manufacturer,
            BuildNumber
        }

        static void Main(string[] args)
        {

            GetCPUDetails();
            GetRAMDetails();
            GetDiskSpaceDetails();
            GetOSDetails();
            //AddressWidth Caption MaxClockSpeed NumberOfCores SystemName
        }

        static void GetCPUDetails()
        {
            Console.WriteLine(" ****************** Sytem Processsor Details  ********************************");
            string Key = "Win32_Processor";
            ManagementObjectSearcher searcher = new ManagementObjectSearcher("select * from " + Key);
            foreach (ManagementObject share in searcher.Get())
            {
                // Some Codes ...
                PropertyDataCollection propdatacollecion = share.Properties;
                foreach (PropertyData pdata in propdatacollecion)
                {

                    switch (pdata.Name)
                    {
                      //  case "AddressWidth": { Console.WriteLine(string.Format("******* Processor Acrchitecture 64 bit / 32 Bit --     {1}: bit *******", pdata.Name, pdata.Value));  break; }
                     //   case "Caption": { Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }
                     //   case "MaxClockSpeed": { Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }
                        case "NumberOfCores": { Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }
                        case "Name": { Console.WriteLine(string.Format("******* Processor {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }

                    }
                }
                

            }
        }

        static void GetRAMDetails()
        {
           Console.WriteLine(" ****************** System Memory and Other Details  ********************************");
           string Key = "Win32_ComputerSystem";
            ManagementObjectSearcher searcher = new ManagementObjectSearcher("select * from " + Key);
            foreach (ManagementObject share in searcher.Get())
            {
                // Some Codes ...
                PropertyDataCollection propdatacollecion = share.Properties;
                foreach (PropertyData pdata in propdatacollecion)
                {
                    switch (pdata.Name)
                    {
                        case "SystemType" : { Console.WriteLine(string.Format("******* Processor Acrchitecture 64 bit / 32 Bit --     {1}: bit *******", pdata.Name, pdata.Value)); break; }
                        case "TotalPhysicalMemory": { Console.WriteLine(string.Format("******* {0}:     {1} GB  *******", pdata.Name, getSizeinGB(pdata.Value.ToString()))); break; }
                        case "UserName" : { Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }
                        case "Manufacturer" :{ Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }
                        case "Model": { Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }
                    }
                    //Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value));
                }
            }
        }
        static void GetDiskSpaceDetails()


        {
            Console.WriteLine(" ****************** System Hard Disk Size Details:  ********************************");
            foreach (System.IO.DriveInfo label in System.IO.DriveInfo.GetDrives())
            {

                if (label.IsReady)
                {
                    Console.WriteLine(string.Format("*** Label Name : {0} TotalSize: {1} GB   FreeSpace: {2} GB ", label.Name, getSizeinGB(label.TotalSize.ToString()), getSizeinGB(label.TotalFreeSpace.ToString())));
                }
            }
        }


        static void GetOSDetails()
        {
            
                 Console.WriteLine(" ****************** System Operating System Details  ********************************");
                 string Key = "Win32_OperatingSystem";
            ManagementObjectSearcher searcher = new ManagementObjectSearcher("select * from " + Key);
            foreach (ManagementObject share in searcher.Get())
            {
                // Some Codes ...
                PropertyDataCollection propdatacollecion = share.Properties;
                foreach (PropertyData pdata in propdatacollecion)
                {
                    switch (pdata.Name)
                    {
                        case "BuildNumber": { Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }
                        case "Caption": { Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }
                        case "Manufacturer": { Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }
                        case "OSArchitecture": { Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value)); break; }
                    }
                   // Console.WriteLine(string.Format("******* {0}:     {1}:  *******", pdata.Name, pdata.Value));
                }
            }
        }

        private static string getSizeinGB(string size)

        {
            string getSizeinGB = String.Empty;
            double sz;
            Double.TryParse(size, out  sz);
            sz = sz / Math.Pow(10, 9);
            sz = sz / 1.074;
            getSizeinGB = sz.ToString();
            return getSizeinGB;
        }
    }
}
