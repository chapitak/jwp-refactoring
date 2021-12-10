package kitchenpos.acceptance;

import static kitchenpos.acceptance.step.TableAcceptanceStep.테이블_저장되어_있음;
import static kitchenpos.acceptance.step.TableGroupAcceptanceStep.단체_지정_되어_있음;
import static kitchenpos.acceptance.step.TableGroupAcceptanceStep.단체_지정_됨;
import static kitchenpos.acceptance.step.TableGroupAcceptanceStep.단체_지정_요청;
import static kitchenpos.acceptance.step.TableGroupAcceptanceStep.단체_해제_됨;
import static kitchenpos.acceptance.step.TableGroupAcceptanceStep.단체_해제_요청;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;
import kitchenpos.domain.OrderTable;
import kitchenpos.domain.TableGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("테이블 그룹 관련 기능")
class TableGroupAcceptanceTest extends AcceptanceTest {

    @Test
    @DisplayName("단체 지정을 등록할 수 있다.")
    void create() {
        //given
        OrderTable firstOrderTable = 테이블_저장되어_있음(3, true);
        OrderTable secondOrderTable = 테이블_저장되어_있음(5, true);
        List<Long> orderTableIds = Arrays.asList(firstOrderTable.getId(), secondOrderTable.getId());

        //when
        ExtractableResponse<Response> response = 단체_지정_요청(orderTableIds);

        //then
        단체_지정_됨(response, orderTableIds);
    }

    @Test
    @DisplayName("단체 지정을 해제할 수 있다.")
    void ungroup() {
        //given
        OrderTable firstOrderTable = 테이블_저장되어_있음(3, true);
        OrderTable secondOrderTable = 테이블_저장되어_있음(5, true);
        TableGroup tableGroup = 단체_지정_되어_있음(
            Arrays.asList(firstOrderTable.getId(), secondOrderTable.getId()));

        //when
        ExtractableResponse<Response> response = 단체_해제_요청(tableGroup);

        //then
        단체_해제_됨(response);
    }
}