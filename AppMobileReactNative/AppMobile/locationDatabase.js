import SQLite from 'react-native-sqlite-storage';

errorCB(error)
{
    console.log("SQL error: " + errpr);
}

successCB()
{
    console.log("SQL executed fine.");
}

openCB()
{
    console.log("Database opened.");
}

var database = SQLite.opnDatabase("test.db", "1.0", "Test database", 200000, openCB, errorCB);
