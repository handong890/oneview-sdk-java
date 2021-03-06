/*******************************************************************************
 * (C) Copyright 2015 Hewlett Packard Enterprise Development LP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.hp.ov.sdk.exceptions;

public enum SDKErrorEnum implements SDKErrorKey {

    fail("FAIL"),
    invalidArgument("INVALID_ARGUMENT"),
    invalidUrl("INVALID_URL"),
    fileNotFound("FILE_NOTFOUND"),
    internalError("INTERNAL_SDK_EXCEPTION"),
    noResponseFromAppliance("NO_RESPONSE"),
    scmbConnectionNotFound("SCMB_CONNECTION_NOT_FOUND"),
    resourceNotFound("RESOURCE_NOT_FOUND"),
    certificateError("CERTIFICATE_ERROR"),
    rabbitMqCertificateError("RABBIT_MQ_CERTIFICATE_ERROR"),
    badRequestError("BAD_REQUEST"),
    forbiddenRequestError("FORBIDDEN_REQUEST"),
    methodNotFound("METHOD_NOT_FOUND"),
    tasksError("TASKS_ERROR"),
    applicanceNotReachable("APPLIANCE_NOT_REACHABLE"),
    apiMismatchError("API_VERSION_MISMATCH"),
    invalidOperationException("INVALID_OPERATION_EXCEPTION"),
    unauthorized("UNAUTHORIZED"),
    internalServerError("INTERNAL_SERVER_ERROR"),
    sslHandshakeException("SSL_HANDSHAKE_EXCEPTION"),
    socketException("SOCKET_EXCEPTION");

    private final String baseKeyName;

    private SDKErrorEnum(final String baseKeyName) {
        this.baseKeyName = baseKeyName;
    }

    @Override
    public String getErrorCode() {
        return "SDK_" + baseKeyName;
    }

    @Override
    public String getMessageKey() {
        return baseKeyName + "_MESSAGE";
    }

    @Override
    public String getResolutionKey() {
        return baseKeyName + "_RESOLUTION";
    }

    @Override
    public String getDetailsKey() {
        return baseKeyName + "_DETAILS";
    }

    @Override
    public String getRecommendedActionsKey() {
        return baseKeyName + "_RECOMMENDED_ACTIONS";
    }

}
