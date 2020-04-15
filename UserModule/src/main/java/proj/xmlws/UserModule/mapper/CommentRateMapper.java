package proj.xmlws.UserModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.UserModule.dto.CommentRateDTO;
import proj.xmlws.UserModule.model.reservation.CommentRate;

@Mapper(componentModel = "spring")
public interface CommentRateMapper {

    CommentRate map(CommentRateDTO commentRateDTO);

    CommentRateDTO map(CommentRate commentRate);
}
