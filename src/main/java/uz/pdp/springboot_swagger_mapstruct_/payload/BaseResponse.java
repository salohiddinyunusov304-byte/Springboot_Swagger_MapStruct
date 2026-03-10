package uz.pdp.springboot_swagger_mapstruct_.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL) // success yoki error null bolsa ciqarmaydi
public class BaseResponse<T> {
    Boolean success;
    T data;
    ErrorDto errorDto;

    // success bolsa
    public BaseResponse(T data) {
        this.success = true;
        this.data = data;
    }

    // error bolsa
    public BaseResponse(ErrorDto errorDto) {
        this.success = false;
        this.errorDto = errorDto;
    }

    public BaseResponse<T> ok(T data) {
        this.success = true;
        this.data = data;
        return this;
    }

    public BaseResponse<T> error(ErrorDto errorDto) {
        this.success = false;
        this.errorDto = errorDto;
        return this;
    }

}
