package ${package};

import lombok.*;

/**
<#if modelDescription??>
 * <P> ${modelDescription!} </P>
</#if>
 * Created by ${author} on ${date}
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ${modelName} {
<#list properties?keys as name>
    private ${properties[name].type} ${name};
</#list>



}
