package com.project4.wilco.project4;

import android.content.Context;
import android.provider.BaseColumns;

/**
 * Created by Wilco on 24-6-2016.
 */
public final class FeedReaderContract {
        private Context context;
        // To prevent someone from accidentally instantiating the contract class,
        // give it an empty constructor.
        public FeedReaderContract() {

        }
    public FeedReaderContract(Context context){
        this.context = context;
    }

        /* Inner class that defines the table contents */
        public static abstract class FeedEntry implements BaseColumns {
            public static final String TABLE_NAME = "fietsdiefstal";
            public static final String COLUMN_NAME1 = "voorvalnummer";
            public static final String COLUMN_NAME2 = "district";
            public static final String COLUMN_NAME3 = "werkgebied";
            public static final String COLUMN_NAME4 = "plaats";
            public static final String COLUMN_NAME5 = "buurt";
            public static final String COLUMN_NAME6 = "straat";
            public static final String COLUMN_NAME7 = "begin_dagsoort";
            public static final String COLUMN_NAME8 = "begindatum";
            public static final String COLUMN_NAME9 = "begintijd";
            public static final String COLUMN_NAME10 = "eind_dagsoort";
            public static final String COLUMN_NAME11 = "einddatum";
            public static final String COLUMN_NAME12 = "eindtijd";
            public static final String COLUMN_NAME13 = "gemjaar";
            public static final String COLUMN_NAME14 = "gemmaand";
            public static final String COLUMN_NAME15 = "gemdag";
            public static final String COLUMN_NAME16 = "gemdagdeel";
            public static final String COLUMN_NAME17 = "trefwoord";
            public static final String COLUMN_NAME18 = "voertuig";
            public static final String COLUMN_NAME19 = "merk";
            public static final String COLUMN_NAME20 = "type";
            public static final String COLUMN_NAME21 = "kleur";



    }
}

