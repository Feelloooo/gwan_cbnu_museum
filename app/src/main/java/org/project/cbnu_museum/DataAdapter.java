package org.project.cbnu_museum;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class DataAdapter
{
    protected static final String TAG = "DataAdapter";

    // TODO : TABLE 이름을 명시해야함
    protected static final String TABLE_NAME1 = "heritage1";
    protected static final String TABLE_NAME2 = "heritage2";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;

    public DataAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public DataAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public DataAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public ArrayList getTableData1()
    {
        try
        {
            // Table 이름 -> antpool_bitcoin 불러오기
            String sql ="SELECT * FROM " + TABLE_NAME1;

            // 모델 넣을 리스트 생성
            ArrayList userList = new ArrayList();

            // TODO : 모델 선언
            Heritage heritage = null;

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur!=null)
            {
                // 칼럼의 마지막까지
                while( mCur.moveToNext() ) {

                    // TODO : 커스텀 모델 생성
                    heritage = new Heritage();

                    // TODO : Record 기술
                    // id, name, account, privateKey, secretKey, Comment
                    heritage.setName(mCur.getString(0));
                    heritage.setAddress(mCur.getString(1));
                    heritage.setDescription(mCur.getString(2));
                    heritage.setEra(mCur.getString(3));
                    heritage.setPlace(mCur.getString(4));
                    heritage.setDetail(mCur.getString(5));

                    // 리스트에 넣기
                    userList.add(heritage);
                }

            }
            return userList;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

    public ArrayList getTableData2()
    {
        try
        {
            // Table 이름 -> antpool_bitcoin 불러오기
            String sql ="SELECT * FROM " + TABLE_NAME2;

            // 모델 넣을 리스트 생성
            ArrayList userList = new ArrayList();

            // TODO : 모델 선언
            Heritage heritage = null;

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur!=null)
            {
                // 칼럼의 마지막까지
                while( mCur.moveToNext() ) {

                    // TODO : 커스텀 모델 생성
                    heritage = new Heritage();

                    // TODO : Record 기술
                    // id, name, account, privateKey, secretKey, Comment
                    heritage.setName(mCur.getString(0));
                    heritage.setAddress(mCur.getString(1));
                    heritage.setDescription(mCur.getString(2));
                    heritage.setEra(mCur.getString(3));
                    heritage.setPlace(mCur.getString(4));
                    heritage.setDetail(mCur.getString(5));

                    // 리스트에 넣기
                    userList.add(heritage);
                }

            }
            return userList;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

}