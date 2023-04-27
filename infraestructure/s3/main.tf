module "bucket" {
  source = "./modules/s3"
  bucket_name = var.bucket_name
  common_tags = local.common_tags
}