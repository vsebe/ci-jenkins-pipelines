class Config19 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: 'hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        temurin     : '--enable-dtrace',
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        "openj9"    : '-create-jre-image'
                ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : [
                        openj9      : 'hw.arch.x86 && sw.os.linux && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                dockerImage: [
                        temurin     : 'adoptopenjdk/centos6_build_image'
                ],
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalTestLabels: [
                        openj9      : '!(sw.os.cent.6||sw.os.rhel.6)'
                ],
                configureArgs       : [
                        openj9      : '--enable-dtrace --enable-jitserver --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        temurin     : '--enable-dtrace'
                ],
                buildArgs           : [
                        "temurin"   : '--create-source-archive --create-jre-image',
                        "openj9"    : '--create-jre-image'
                ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes'
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: 'hw.arch.x86 && sw.os.windows',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        openj9      :'--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"'
                ],
                buildArgs           : [
                        "openj9"    : '--create-jre-image'
                ]
        ],

        // TODO: Enable testing (https://github.com/adoptium/ci-jenkins-pipelines/issues/77)
        aarch64Windows: [
                os                  : 'windows',
                arch                : 'aarch64',
                crossCompile        : 'x64',
                buildArgs           : '--cross-compile',
                additionalNodeLabels: 'win2016&&vs2019',
                test                : [
                        nightly: [],
                        weekly : []
                ]
        ],


        x32Windows: [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: 'win2012&&vs2017',
                buildArgs           : [
                        temurin : '--jvm-variant client,server'
                ],
                test                : 'default'
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        temurin     : 'xlc16&&aix710',
                        openj9      : 'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                : 'default',
                configureArgs       : [
                        openj9      : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                cleanWorkspaceAfterBuild: true,
                buildArgs           : [
                        "openj9"    : '--create-jre-image'
                ]
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: 'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)',
                configureArgs       : [
                        temurin     : '--enable-dtrace',
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        "openj9"    : '--create-jre-image'
                ]
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: 'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)',
                configureArgs       : [
                        temurin     : '--enable-dtrace',
                        openj9      : '--enable-dtrace --enable-jitserver --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        "openj9"    : '--create-jre-image'
                ]
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9      : 'hw.arch.aarch64 && sw.os.linux && sw.os.cent.7'
                ],
                dockerImage         : [
                        temurin     : 'adoptopenjdk/centos7_build_image'
                ],
                test                : 'default',
                configureArgs       : [
                        temurin     : '--enable-dtrace',
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        "openj9"    : '--create-jre-image'
                ]
        ],

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        temurin     : 'macos11',
                        openj9      : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.mac'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        openj9      : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs --disable-ddr --with-version-pre=ea --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                test                : [
                        hotspot : 'default',
                        openj9 : ['sanity.functional', 'extended.functional', 'sanity.openjdk', 'sanity.system']
                ],
                buildArgs           : [
                        "openj9"    : '--create-jre-image'
                ]
        ],

        arm32Linux    : [
                os                  : 'linux',
                arch                : 'arm',
                test                : 'default',
                configureArgs       : '--enable-dtrace'
        ],
        riscv64Linux      :  [
                os                   : 'linux',
                arch                 : 'riscv64',
                configureArgs        : '--enable-dtrace --with-native-debug-symbols=none',
                buildArgs            : '-r https://github.com/openjdk/riscv-port -b riscv-port --custom-cacerts false --disable-adopt-branch-safety',
                test                : [
                        nightly: ['sanity.openjdk'],
                        weekly : ['sanity.openjdk', 'sanity.system', 'extended.system', 'sanity.perf']
                ]
        ]

  ]

}

Config19 config = new Config19()
return config.buildConfigurations
