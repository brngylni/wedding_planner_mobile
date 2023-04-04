package com.example.wedding_planner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.wedding_planner.models.*;

public class DBAdapter{
    static final String DATABASE_NAME = "weddingPlanner_DB";
    static final int DATABASE_VERSION = 1;
    static final String USERS_CREATE =
            "CREATE TABLE \"Users\" (\n" +
                    "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                    "\t\"username\"\tTEXT NOT NULL UNIQUE,\n" +
                    "\t\"password\"\tTEXT NOT NULL,\n" +
                    "\t\"name\"\tTEXT NOT NULL,\n" +
                    "\t\"surname\"\tTEXT NOT NULL,\n" +
                    "\t\"dob\"\tTEXT NOT NULL,\n" +
                    "\t\"type\"\tINTEGER NOT NULL,\n" +
                    "\t\"mail\"\tTEXT NOT NULL,\n" +
                    "\t\"phone\"\tTEXT NOT NULL,\n" +
                    "\t\"gender\"\tTEXT NOT NULL,\n" +
                    "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                    ");";
    static final String WEDDINGS_CREATE =
            "CREATE TABLE \"Weddings\" (\n" +
                    "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                    "\t\"name\"\tTEXT NOT NULL,\n" +
                    "\t\"date\"\tTEXT NOT NULL,\n" +
                    "\t\"time\"\tTEXT NOT NULL,\n" +
                    "\t\"dinner_option\"\tINTEGER NOT NULL,\n" +
                    "\t\"guests\"\tINTEGER NOT NULL,\n" +
                    "\t\"band_option\"\tINTEGER NOT NULL,\n" +
                    "\t\"photographer_option\"\tINTEGER NOT NULL,\n" +
                    "\t\"alcohol\"\tINTEGER NOT NULL,\n" +
                    "\t\"dinner_menu\"\tINTEGER,\n" +
                    "\t\"photographer_id\"\tINTEGER,\n" +
                    "\t\"band_id\"\tINTEGER,\n" +
                    "\t\"user_id\"\tINTEGER NOT NULL,\n" +
                    "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                    ");";
    static final String BANDS_CREATE =
            "CREATE TABLE \"Bands\" (\n" +
                    "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                    "\t\"name\"\tTEXT NOT NULL,\n" +
                    "\t\"musicians\"\tINTEGER NOT NULL,\n" +
                    "\t\"genre\"\tTEXT NOT NULL,\n" +
                    "\t\"song_list\"\tTEXT NOT NULL,\n" +
                    "\tPRIMARY KEY(\"id\")\n" +
                    ");";
    static final String DINNER_MENUS_CREATE =
            "CREATE TABLE \"Dinner_Menus\" (\n" +
                    "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                    "\t\"name\"\tTEXT NOT NULL,\n" +
                    "\t\"description\"\tTEXT NOT NULL,\n" +
                    "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                    ");";

    static final String DATABASE_CREATE = USERS_CREATE + BANDS_CREATE + DINNER_MENUS_CREATE + WEDDINGS_CREATE;
    final Context context;
    DBHelper DBHelper;
    SQLiteDatabase db;
    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DBHelper(context);
        db = DBHelper.getWritableDatabase();
    }

    private static class DBHelper extends SQLiteOpenHelper{

        public DBHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        }
    }

    public long insertUser(User user)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put("name", user.getName());
        initialValues.put("username", user.getUsername());
        initialValues.put("surname", user.getSurname());
        initialValues.put("password", user.getPassword());
        initialValues.put("dob", user.getDob());
        initialValues.put("type", user.getType());
        initialValues.put("phone", user.getPhone());
        initialValues.put("email", user.getMail());
        return db.insert("Users", null, initialValues);
    }

    public long insertBand(Band band)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put("name", band.getName());
        initialValues.put("genre", band.getGenre());
        initialValues.put("musicians", band.getMusicians());
        initialValues.put("song_list", band.getSong_list());
        return db.insert("Bands", null, initialValues);
    }
    public long insertWedding(Wedding wedding)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put("name", wedding.getName());
        initialValues.put("date", wedding.getDate());
        initialValues.put("time", wedding.getTime());
        initialValues.put("dinner_option", wedding.getDinner_option());
        initialValues.put("guests", wedding.getGuests());
        initialValues.put("band_option", wedding.getBand_id());
        initialValues.put("photographer_option", wedding.getPhotographer_option());
        initialValues.put("alcohol", wedding.getAlcohol());
        initialValues.put("dinner_menu", wedding.getDinner_menu().getId());
        initialValues.put("photographer_id", wedding.getPhotographer_id());
        initialValues.put("band_id", wedding.getBand_id());
        initialValues.put("alcohol", wedding.getAlcohol());
        initialValues.put("user_id", wedding.getUser_id());
        return db.insert("Users", null, initialValues);
    }

    public boolean deleteUser(int rowId)
    {
        return db.delete("Users", "id" + "=" + rowId, null) > 0;
    }

    public boolean deleteWedding(int rowId)
    {
        return db.delete("Weddings", "id" + "=" + rowId, null) > 0;
    }

    public boolean deleteBand(int rowId)
    {
        return db.delete("Bands", "id" + "=" + rowId, null) > 0;
    }

    public Cursor getAllUsers()
    {
        return db.rawQuery("select * from Users", null);
    }
    public Cursor getAllBands()
    {
        return db.rawQuery("select * from Bands", null);
    }
    public Cursor getAllWeddings()
    {
        return db.rawQuery("select * from Weddings", null);
    }
    public Cursor getAllDinner_Menus()
    {
        return db.rawQuery("select * from Dinner_Menus", null);
    }

    public Cursor getUser(String username) throws SQLException
    {
        Cursor mCursor = db.rawQuery(String.format("select * from Users WHERE username='%s'", username), null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public Cursor getWedding(int id) throws SQLException
    {
        Cursor mCursor = db.rawQuery(String.format("select * from Weddings WHERE id=%s", id), null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public Cursor getBand(int id) throws SQLException
    {
        Cursor mCursor = db.rawQuery(String.format("select * from Bands WHERE id=%s", id), null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public Cursor getDinner_Menu(int id) throws SQLException
    {
        Cursor mCursor = db.rawQuery(String.format("select * from Dinner_Menus WHERE id=%s", id), null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateUser(User user)
    {
        ContentValues args = new ContentValues();
        args.put("username", user.getUsername());
        args.put("name", user.getName());
        args.put("surname", user.getSurname());
        args.put("password", user.getPassword());
        args.put("dob", user.getDob());
        args.put("type", user.getType());
        args.put("phone", user.getPhone());
        args.put("email", user.getMail());
        return db.update("Users", args, "id" + "=" + user.getId(), null) > 0;
    }

    public boolean updateWedding(Wedding wedding)
    {
        ContentValues args = new ContentValues();
        args.put("name", wedding.getName());
        args.put("date", wedding.getDate());
        args.put("time", wedding.getTime());
        args.put("dinner_option", wedding.getDinner_option());
        args.put("guests", wedding.getGuests());
        args.put("band_option", wedding.getBand_id());
        args.put("photographer_option", wedding.getPhotographer_option());
        args.put("alcohol", wedding.getAlcohol());
        args.put("dinner_menu", wedding.getDinner_menu().getId());
        args.put("photographer_id", wedding.getPhotographer_id());
        args.put("band_id", wedding.getBand_id());
        args.put("alcohol", wedding.getAlcohol());
        args.put("user_id", wedding.getUser_id());
        return db.update("Weddings", args, "id" + "=" + wedding.getId(), null) > 0;
    }

    public boolean updateBand(Band band)
    {
        ContentValues args = new ContentValues();
        args.put("name", band.getName());
        args.put("genre", band.getGenre());
        args.put("musicians", band.getMusicians());
        args.put("song_list", band.getSong_list());
        return db.update("Bands", args, "id" + "=" + band.getId(), null) > 0;
    }

}
