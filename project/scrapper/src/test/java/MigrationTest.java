import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;



public class MigrationTest extends IntegrationEnvironment{

    @Test
    @Transactional
    @Rollback
    void migrationsAreRunningSuccessfully() throws Exception {
            //given
        try (var connection = DB_CONTAINER.createConnection("")){
            var preparedStatementForUpdate = connection.prepareStatement
                    ("INSERT INTO tg_chat(id, created_at, created_by) VALUES (1, now(), 'Vlad')");

            var preparedStatementForQuery = connection.prepareStatement("SELECT * FROM tg_chat");

            //when
            var resultUpdate = preparedStatementForUpdate.executeUpdate();

            var resultQuery = preparedStatementForQuery.executeQuery();
            resultQuery.next();

            //then
            assertAll(
                    () -> assertEquals(1, resultUpdate),
                    () -> assertEquals("Vlad", resultQuery.getString("created_by"))
            );
        }
    }
}
