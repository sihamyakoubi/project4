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
        public static Java.IO.File path;
        protected override void OnCreate(Bundle bundle)
        {
            MainActivity.path = GetDir("fietsdiefstal.csv", FileCreationMode.WorldReadable);
            
            base.OnCreate(bundle);
            //StreamReader x = new StreamReader(Assets.Open("fietstrommel.csv"));
         
            
            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);

            // Get our button from the layout resource,
            // and attach an event to it
            Button button = FindViewById<Button>(Resource.Id.MyButton);
            Button button2 = FindViewById<Button>(Resource.Id.MyButton2);


            button.Click += delegate
            {
                Data1 fietstrommel = new Data1();
                button.Visibility = ViewStates.Invisible;
                button2.Visibility = ViewStates.Visible;
            };

            button2.Click += delegate
            {
                button2.Text = Data1.deelgem[25];
            };





            //button.Visibility = Android.Views.ViewStates.Invisible;
        }


    }
    
    }


