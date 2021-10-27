class Config17 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                configureArgs       : '--enable-dtrace --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
        ],

        x64MacIBM    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        "openj9"      : '--enable-dtrace --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Certified Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk17 -b ibm_sdk"
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage: [
                        hotspot     : 'adoptopenjdk/centos6_build_image',
                        openj9      : 'adoptopenjdk/centos7_build_image'
                ],
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalTestLabels: [
                        openj9      : '!(sw.os.cent.6||sw.os.rhel.6)'
                ],
                configureArgs       : [
                        "openj9"      : '--enable-dtrace --enable-jitserver --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                        "hotspot"     : '--enable-dtrace'
                ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes'
        ],

        x64LinuxIBM  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerFile: [
                        "openj9"  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                additionalTestLabels: [
                        openj9      : '!(centos6||rhel6)'
                ],
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --enable-dtrace --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Certified Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk17 -b ibm_sdk"
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                cleanWorkspaceAfterBuild: true,
                configureArgs: '--with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Runtime"',
                test                : 'default'
        ],

        x64WindowsIBM: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
                ],
                buildArgs : [
                        openj9 : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk17 -b ibm_sdk"
                ],
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Certified Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Runtime"'
                ],
                additionalFileNameTag: "IBM"
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
                buildArgs : [
                        hotspot : '--jvm-variant client,server'
                ],
                test                : 'default'
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        hotspot: 'xlc16&&aix710',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                : 'default',
                configureArgs : [
                        openj9: '--disable-ccache --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ],
                cleanWorkspaceAfterBuild: true
        ],

        ppc64AixIBM    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--disable-ccache --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Certified Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk17 -b ibm_sdk"
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : '--enable-dtrace --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
        ],

        s390xLinuxIBM    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : '--enable-dtrace --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Certified Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk17 -b ibm_sdk"
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                additionalNodeLabels: 'centos7',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        "hotspot"     : '--enable-dtrace',
                        "openj9"      : '--enable-dtrace --enable-jitserver --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ]
        ],

        ppc64leLinuxIBM    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        "openj9"      : '--enable-dtrace --enable-jitserver --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Certified Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk17 -b ibm_sdk"
        ],

        aarch64LinuxIBM    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                testDynamic         : false,
                configureArgs       : [
                        openj9      : '--enable-dtrace --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Certified Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk17 -b ibm_sdk"
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                configureArgs       : '--enable-dtrace --with-vendor-name="IBM Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
        ],

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: 'macos11',
                test                : 'default'
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
                buildArgs            : '-r https://github.com/openjdk/jdk-sandbox -b riscv-port-branch --custom-cacerts false --disable-adopt-branch-safety',
                test                : [
                        nightly: ['sanity.openjdk'],
                        weekly : ['sanity.openjdk', 'sanity.system', 'extended.system', 'sanity.perf']
                ]
        ]

  ]

}

Config17 config = new Config17()
return config.buildConfigurations
