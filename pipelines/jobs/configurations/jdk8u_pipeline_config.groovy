class Config8 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac        : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: [
                        temurin : 'macos10.14',
                        corretto: 'build-macstadium-macos1010-1',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test                 : 'default'
        ],

        x64Linux      : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile',
                        dragonwell: 'pipelines/build/dockerFiles/dragonwell.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                 : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        "dragonwell"  : '--enable-unlimited-crypto --with-jvm-variants=server --with-zlib=system',
                ],
                buildArgs           : [
                        "temurin"   : '--create-source-archive'
                ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--disable-headful'
        ],

        aarch64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--disable-headful'
        ],

        x64Windows    : [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        temurin : 'win2012&&vs2017',
                        corretto: 'win2012',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                        dragonwell: 'win2012'
                ],
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test                 : 'default'
        ],

        x32Windows    : [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: [
                        temurin : 'win2012',
                        corretto: 'win2012',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
                ],
                buildArgs : [
                        temurin : '--jvm-variant client,server'
                ],
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test                 : 'default'
        ],

        ppc64Aix      : [
                os  : 'aix',
                arch: 'ppc64',
                additionalNodeLabels: [
                        temurin: 'xlc13&&aix710',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                 : 'default',
                configureArgs: [
                    "openj9"        : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                cleanWorkspaceAfterBuild: true
        ],

        s390xLinux    : [
                os  : 'linux',
                arch: 's390x',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test: [
                        temurin: ['sanity.openjdk'],
                        openj9: 'default'
                ]
        ],

        sparcv9Solaris: [
                os  : 'solaris',
                arch: 'sparcv9',
                test: 'default'
        ],

        x64Solaris    : [
                os                  : 'solaris',
                arch                : 'x64',
                test                : 'default'
        ],

        ppc64leLinux  : [
                os  : 'linux',
                arch: 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                 : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ]
        ],

        arm32Linux    : [
                os  : 'linux',
                arch: 'arm',
                test: 'default'
        ],

        aarch64Linux  : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerFile: [
                        dragonwell: 'pipelines/build/dockerFiles/dragonwell_aarch64.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                cleanWorkspaceAfterBuild: true,
                test                 : 'default'
        ],
  ]

}

Config8 config = new Config8()
return config.buildConfigurations
