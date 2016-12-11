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
database.transaction((t) => 
{
    t.executeSql('SELECT * FROM Employees a, Departments b WHERE a.department = b.department_id', [], (t, results) => 
    {
        console.log("Query completed");

      // Get rows with Web SQL Database spec compliance.

      var len = results.rows.length;
      for (let i = 0; i < len; i++) {
        let row = results.rows.item(i);
        console.log(`Employee name: ${row.name}, Dept Name: ${row.deptName}`);
      }
    })
})
