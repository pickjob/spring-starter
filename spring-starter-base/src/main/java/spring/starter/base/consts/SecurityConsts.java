package spring.starter.base.consts;

import java.util.List;

/**
 * @author pickjob@126.com
 * @date 2020-10-29
 */
public interface SecurityConsts {
    static final String GET = "get:";
    static final String POST = "post:";
    static final String DELETE = "delete:";
    static final String VERSION = "v1:";

    static final String PERMISSION_AUTH_PASS = GET + VERSION + "auth:pass";

    // cache
    static final String PERMISSION_CACHE_AUTO_CACHE = GET + VERSION + "cache:auto-cache";
    static final String PERMISSION_CACHE_FORCE_CACHE = POST + VERSION + "cache:force-cache";
    static final String PERMISSION_CACHE_EVICT_CACHE = DELETE + VERSION + "cache:evict-cache";

    // upload
    static final String PERMISSION_UPLOAD = POST + VERSION + "upload";

    // validation
    static final String PERMISSION_VALIDATION = POST + VERSION + "validation";

    static final String SECURITY_HEADER = "Security-Header";

    static final List<String> SECURITY_ROLES = List.of(

    );

    static final List<String> SECURITY_PERMISSIONS = List.of(
            PERMISSION_CACHE_AUTO_CACHE,
            PERMISSION_CACHE_FORCE_CACHE,
            PERMISSION_CACHE_EVICT_CACHE,
            PERMISSION_UPLOAD,
            PERMISSION_VALIDATION,
            PERMISSION_AUTH_PASS
    );





}
