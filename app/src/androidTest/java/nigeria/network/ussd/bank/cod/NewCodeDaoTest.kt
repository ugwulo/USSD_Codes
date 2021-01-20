package nigeria.network.ussd.bank.cod

import android.content.Context
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import nigeria.network.ussd.bank.cod.data.new_code.NewCode
import nigeria.network.ussd.bank.cod.data.new_code.NewCodeDao
import nigeria.network.ussd.bank.cod.data.new_code.NewCodeDatabase
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith

/**
 * adding test for the app's db.
 */
@RunWith(AndroidJUnit4::class)
class NewCodeDaoTest {
    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var database: NewCodeDatabase
    private lateinit var newCodeDao: NewCodeDao

    @Before
    fun setup() {
        val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
        try {
            database = Room.inMemoryDatabaseBuilder(context, NewCodeDatabase::class.java)
                .allowMainThreadQueries().build()
        } catch (e: Exception) {
            Log.i("test", e.message)
        }
        newCodeDao = database.newCodeDao()
    }

    @Test
    suspend fun testAddingAndRetrievingData() {
        // 1
        val preInsertRetrievedCodes = newCodeDao.getSavedCodes()

        // 2
        val newCode = NewCode(1, "customer service", "180")
        newCodeDao.insertNewCode(newCode)

        // 3
        val postInsertRetrievedCodes = newCodeDao.getSavedCodes()
        val sizeDifference = postInsertRetrievedCodes.size - preInsertRetrievedCodes.size
        Assert.assertEquals(1, sizeDifference)
        val retrievedCode = postInsertRetrievedCodes.last()
        Assert.assertEquals("customer service", retrievedCode.codeName)
    }

    @After
    fun tearDown() {
        database.close()
    }
}