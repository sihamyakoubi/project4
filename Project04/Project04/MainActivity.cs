using System;
using Android.App;
using Android.Content;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.OS;
using System.Collections.Generic;
using System.IO;

namespace Project04
{
    [Activity(Label = "Project04", MainLauncher = true, Icon = "@drawable/icon")]
    public class MainActivity : Activity
    {
       protected override void OnCreate(Bundle bundle)
        {
            fietstrommel fietstrommel = new fietstrommel();
            base.OnCreate(bundle);
            
            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);

            // Get our button from the layout resource,
            // and attach an event to it
            Button button = FindViewById<Button>(Resource.Id.MyButton);


            button.Click += delegate
            {
                
                button.Text = fietstrommel.straat[25];
            };





            //button.Visibility = Android.Views.ViewStates.Invisible;
        }
    }
    class fietstrommel
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

        public fietstrommel()
        {


            var reader = new StreamReader(File.OpenRead(@"drawable\fietstrommel.csv"));

            while (!reader.EndOfStream)
            {
                var line = reader.ReadLine();
                var values = line.Split(',');
                //var values2 = values.Split(',');

                fietstrommel.fietsnummer.Add(values[0]);
                fietstrommel.FT.Add(values[1]);
                fietstrommel.Fietstrommel.Add(values[2]);
                fietstrommel.straat.Add(values[3]);
                fietstrommel.thv.Add(values[4]);
                fietstrommel.Xcoord.Add(values[5]);
                fietstrommel.Ycoord.Add(values[6]);
                fietstrommel.deelgem.Add(values[7]);
                fietstrommel.status.Add(values[8]);
                fietstrommel.datum.Add(values[9]);
            }
        }
    }
}

