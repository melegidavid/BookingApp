package proj.xmlws.MessageModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.MessageModule.dto.CommentRateDTO;
import proj.xmlws.MessageModule.model.reservation.CommentRate;

@Mapper(componentModel = "spring")
public interface CommentRateMapper {

    CommentRate map(CommentRateDTO commentRateDTO);

    CommentRateDTO map(CommentRate commentRate);
}
