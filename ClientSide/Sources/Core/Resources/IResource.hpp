/*
 * Copyright 2018 Vladimir Balun
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#pragma once

#include <string>

#include "../Helpers/Macroses.hpp"

namespace Core { namespace Resources {

    FWD_DECL_SMART_PTRS_FOR_STRUCT(IResource)

    struct IResource
    {
        virtual bool load(const std::string& resource_path) noexcept = 0;
        virtual ~IResource() = default;
    };

}}
