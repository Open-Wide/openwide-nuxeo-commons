Open Wide : Nuxeo Commons
=========================

## Introduction

This repository provides various tools and features for your Nuxeo projects. Most of them have been extracted from actual client projects.

**Core**

* `owsi-nuxeo-constants`: Various constants exposed on Java classes, mainly to ease the manipulation of documents.
* `owsi-nuxeo-tests-helper`: Thin helper to set up tests.
* `owsi-nuxeo-utils`: Miscellaneous utility methods, plus an extension point to display your project version.

**Features**

* `owsi-nuxeo-property-sync`: Synchronizes properties from documents to their children.
* `owsi-nuxeo-avatar-importer`: Watches a given folder to import its contents as avatars.
* `owsi-nuxeo-ecm-types-ordering`: Customizes the appearance of the doctype selection pop-up.
* `owsi-nuxeo-document-creation-script`: An alternative to the Content Template service.
* `owsi-nuxeo-generic-properties`: Generic extension point to store simple data.

## How to

#### Get the binaries

The bundles are on Maven Central, meaning you can either:

* [Download them manually](http://search.maven.org/#search|ga|1|g%3A%22fr.openwide.nuxeo.commons%22)
* Embed them in your Maven project, to use them as libraries and/or include them in your Marketplace package (see `Use the bundles in your projects`).

#### Build from sources

* Clone this repository
* Use `mvn install` to add the latest version of these projects to your local repository.

#### Deploy the bundes

You can manually put the build bundles in the *nxserver/bundles* folder of Nuxeo, but if your project is built into a Marketplace package, the preferred way is to make them part of your assembly:

**pom.xml**

```
    ...
    <dependency>
      <groupId>fr.openwide.nuxeo.commons</groupId>
      <artifactId>openwide-nuxeo-constants</artifactId>
      <version>0.1.3</version>
    </dependency>
    <dependency>
      <groupId>fr.openwide.nuxeo.commons</groupId>
      <artifactId>openwide-nuxeo-utils</artifactId>
      <version>0.1.3</version>
    </dependency>
    <dependency>
      <groupId>fr.openwide.nuxeo.commons</groupId>
      <artifactId>openwide-nuxeo-avatar-importer</artifactId>
      <version>0.1.3</version>
    </dependency>
    ...
```

**assembly.xml**

```
<project name="nuxeo-assembly" ...>
  ...
  <copy todir="${outdir}/marketplace/install/bundles">
			<artifact:resolveFile key="fr.openwide.nuxeo.commons:openwide-nuxeo-constants::jar" />
			<artifact:resolveFile key="fr.openwide.nuxeo.commons:openwide-nuxeo-utils::jar" />
			<artifact:resolveFile key="fr.openwide.nuxeo.commons:openwide-nuxeo-avatar-importer::jar" />
			...
  </copy>
  ...
</project>
```

Note that most features require both `owsi-nuxeo-constants` and `owsi-nuxeo-utils` projects, so make sure to deploy them too.

## Licensing

The contents of this repository, unless otherwise mentioned, are licensed under the [LGPL](http://www.gnu.org/copyleft/lesser.html).

## Links

* [Open Wide corporate website](http://www.openwide.fr/)
* [Nuxeo corporate website](http://www.nuxeo.com/fr)

