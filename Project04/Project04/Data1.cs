using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using System.IO;
using Java.IO;

namespace Project04
{
    class Data1 : Activity
    {
        public static List<string> fietsnummer = new List<string>();
        public static List<string> FT = new List<string>();
        public static List<string> Fietstrommel = new List<string>();
        public static List<string> straat = new List<string>();
        public static List<string> thv = new List<string>();
        public static List<string> Xcoord = new List<string>();
        public static List<string> Ycoord = new List<string>();
        public static List<string> deelgem = new List<string>();
        public static List<string> status = new List<string>();
        public static List<string> datum = new List<string>();
        public Data1()
        {
            
            //String path1 = path.ToString();

            //string p = Directory.GetCurrentDirectory();
            // p3 = Path.GetDirectoryName(Application.);
            //string p2 = @"c:\Users\Wilco\Desktop\project4\Project04\Project04\fietstrommel.csv";
            //string p3 = "fietstrommel.csv";



           var reader = new StreamReader(Assets.Open("fietstrommel.csv"));
            
            while (!reader.EndOfStream)
            {
                var line = reader.ReadLine();
                var values = line.Split(',');

                fietsnummer.Add(values[0]);
                FT.Add(values[1]);
                Fietstrommel.Add(values[2]);
                straat.Add(values[3]);
                thv.Add(values[4]);
                Xcoord.Add(values[5]);
                Ycoord.Add(values[6]);
                deelgem.Add(values[7]);
                status.Add(values[8]);
                datum.Add(values[9]);
            }
        }
        

        
}
}
